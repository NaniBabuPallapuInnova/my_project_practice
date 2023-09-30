import { AbstractControl } from "@angular/forms";

export function PasswordValidator(control : AbstractControl){

    // custom validation for confirmPassword. It will make sure length should be between 4 to 8
        if(control && control.value && (control.value === null || control.value ==='' || (control.value.length >=4 && control.value.length <=15))){
            return null;
        }
        return {
            PasswordValidator : true
        };
}

