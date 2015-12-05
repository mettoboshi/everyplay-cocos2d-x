#import <Foundation/Foundation.h>

typedef enum {
    EVERYPLAY_FACECAM_PREVIEW_ORIGIN_TOP_LEFT = 0,
    EVERYPLAY_FACECAM_PREVIEW_ORIGIN_TOP_RIGHT,
    EVERYPLAY_FACECAM_PREVIEW_ORIGIN_BOTTOM_LEFT,
    EVERYPLAY_FACECAM_PREVIEW_ORIGIN_BOTTOM_RIGHT
} EveryplayFaceCamPreviewOrigin;

typedef struct {
    float r, g, b, a;
} EveryplayFaceCamColor;

NS_CLASS_AVAILABLE(10_7, 4_0)
@interface EveryplayFaceCam : NSObject

// Device support and states
@property (nonatomic, readonly) BOOL isVideoRecordingSupported;
@property (nonatomic, readonly) BOOL isAudioRecordingSupported;
@property (nonatomic, readonly) BOOL isHeadphonesPluggedIn;
@property (nonatomic, readonly) BOOL isSessionRunning;
@property (nonatomic, readonly) BOOL isRecordingPermissionGranted;

// Audio levels
@property (nonatomic, readonly) float audioPeakLevel;
@property (nonatomic, readonly) float audioPowerLevel;

// Options
@property (nonatomic, assign) BOOL monitorAudioLevels;
@property (nonatomic, assign) BOOL audioOnly;

// FaceCam preview box properties
@property (nonatomic, assign) EveryplayFaceCamPreviewOrigin previewOrigin;
@property (nonatomic, assign) EveryplayFaceCamColor previewBorderColor;

@property (nonatomic, assign) BOOL previewVisible;
@property (nonatomic, assign) BOOL previewScaleRetina;

@property (nonatomic, assign) int previewSideWidth;
@property (nonatomic, assign) int previewBorderWidth;
@property (nonatomic, assign) int previewPositionX;
@property (nonatomic, assign) int previewPositionY;

// Target texture
@property (nonatomic, assign) int targetTextureId;
@property (nonatomic, weak) id targetTextureMetal;
@property (nonatomic, assign) int targetTextureWidth;
@property (nonatomic, assign) int targetTextureHeight;

- (void)requestRecordingPermission;

- (void)startSession;
- (void)stopSession;

@end
