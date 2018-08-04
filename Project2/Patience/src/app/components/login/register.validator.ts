import { FormGroup } from '@angular/forms';

export class RegistrationValidator {
  static validate(passwordFormGroup: FormGroup) {
    const password = passwordFormGroup.controls.password.value;
    const confirm = passwordFormGroup.controls.passwordconfirm.value;

    if (confirm.length === 0) {
      return null;
    }

    if (confirm !== password) {
      return {
        doesMatchPassword: true
      };
    }
    return null;
  }

}
