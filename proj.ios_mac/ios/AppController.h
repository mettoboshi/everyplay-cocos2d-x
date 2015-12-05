#import <UIKit/UIKit.h>
#import <Everyplay/Everyplay.h> // add

@class RootViewController;

// add EveryplayDelegate
@interface AppController : NSObject <EveryplayDelegate, UIApplicationDelegate> {
    UIWindow *window;
}

@property(nonatomic, readonly) RootViewController* viewController;

@end

