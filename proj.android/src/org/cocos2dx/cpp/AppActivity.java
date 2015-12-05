/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/
package org.cocos2dx.cpp;

import org.cocos2dx.lib.Cocos2dxActivity;

import com.everyplay.Everyplay.Everyplay;
import com.everyplay.Everyplay.IEveryplayListener;

import android.os.Bundle;

public class AppActivity extends Cocos2dxActivity implements IEveryplayListener {
	private static final String TAG = "EveryplayRecord";
	private static String CLIENT_ID = "f77b511414beb1ea7d97762cdc5849e2d2dd27d1";
	private static String CLIENT_SECRET = "2260808cef426ac09037a6d69f4d073e67b380a9";
	private static String REDIRECT_URI = "https://m.everyplay.com/auth";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setup();
	}

	public void setup() {
		Everyplay.configureEveryplay(CLIENT_ID, CLIENT_SECRET, REDIRECT_URI);
		Everyplay.initEveryplay(this, this);

		new Thread(new Runnable(){
	        @Override
	        public void run()
	        {
	            try
	            {
	                Thread.sleep(20000);
	                Everyplay.startRecording();
	                Thread.sleep(10000);
	                Everyplay.stopRecording();
	                Everyplay.playLastRecording();
	            }
	            catch( InterruptedException e )
	            {
	                e.printStackTrace();
	            }
	        }
	    }).start();
	}
	
	@Override
	public void onEveryplayReadyForRecording(int enabled) {
	}

	@Override
	public void onEveryplayRecordingStarted() {
	}

	@Override
	public void onEveryplayRecordingStopped() {
	}

	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public void onEveryplayHidden() {
	}

	@Override
	public void onEveryplayFaceCamSessionStarted() {
	}

	@Override
	public void onEveryplayFaceCamRecordingPermission(int granted) {
	}

	@Override
	public void onEveryplayShown() {
	}

	@Override
	public void onEveryplayFaceCamSessionStopped() {
	}

	@Override
	public void onEveryplayUploadDidStart(int videoId) {
	}

	@Override
	public void onEveryplayUploadDidProgress(int videoId, double progress) {
	}

	@Override
	public void onEveryplayUploadDidComplete(int videoId) {
	}

	@Override
	public void onEveryplayThumbnailReadyAtTextureId(int textureId,
			int portraitMode) {
	}

	@Override
	public void onEveryplayAccountDidChange() {
	}
}
