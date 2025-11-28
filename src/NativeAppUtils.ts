import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';
 
export interface Spec extends TurboModule {
  exitApp(): void;
  restartApp(): void;
}

export default TurboModuleRegistry.getEnforcing<Spec>(
  'NativeAppUtils',
) as Spec;
