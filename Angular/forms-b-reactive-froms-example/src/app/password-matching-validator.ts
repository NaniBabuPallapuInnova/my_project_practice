import { AbstractControl, Validators } from "@angular/forms";

// this funcation is used to validate password and confirmPassword both are same or not.
// instead of passing single FormControl , We are passing FormGroup because we need to validate password and confirmPassword.
export function PasswordMatchingValidator(control : AbstractControl): { [key : string]: boolean } | null { 

    const password = control.get('password'); // fetching from password FormControl password
    const confirmedPassword = control.get('confirmPassword')//fetching from confirmPassword FormControl password

    // it is used to make sure password is entered or not. and touched the confirmedPasswod or not.
    if(password?.pristine || confirmedPassword?.pristine){
        return null;
    }
    // if password and confirmedPassword don't matchi, we are setting misMatch value as true using ternary operator, otherwise it will be set to null.
    return password && confirmedPassword && password.value != confirmedPassword.value ?  { 'misMatch':true} : null 
}