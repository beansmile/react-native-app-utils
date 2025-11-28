#import "RCTAppUtils.h"
#import <React/RCTBridge.h>
#import <React/RCTRootView.h>
#import <UIKit/UIKit.h>

@interface RCTAppUtils()
@end

@implementation RCTAppUtils

- (void)exitApp {
  exit(0);
}

- (void)restartApp {
  dispatch_async(dispatch_get_main_queue(), ^{
    RCTTriggerReloadCommandListeners(@"AppUtils: restart");
  });
}

+ (NSString *)moduleName {
  return @"NativeAppUtils";
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const facebook::react::ObjCTurboModule::InitParams &)params {
  return std::make_shared<facebook::react::NativeAppUtilsSpecJSI>(params);
}

@end
