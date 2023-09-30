import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms'
import { FormControl, } from '@angular/forms'
import { PasswordValidator } from './password-validator';
import { PasswordMatchingValidator } from './password-matching-validator';
import { RegistrationService } from './registration.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Reactive Form Example';
  submitted : boolean = false;

  registerationUserForm! : FormGroup;
  


//   this.registerationUserForm.get('userName'); is replaced by username
// it will be set to class binding in html form.
get userName(){
  return this.registerationUserForm.get('userName');
}

get eMail(){
  return this.registerationUserForm.get('mail');
}

get alterEmails(){
  return this.registerationUserForm.get('alternativeMails') as FormArray;
}


// addAlternativeEmails() a method that can be called dinamyically to insert FormControl into the FormArray
addAlternativeEmails(){
  this.alterEmails.push(this.formBuilder.control(''));
}

// it will be set to class binding in html form.
get password(){
  return this.registerationUserForm.get('password');
}

// it will be set to class binding in html form.
get confirmPass(){
  return this.registerationUserForm.get('confirmPassword');
}





  constructor(private formBuilder : FormBuilder, private registerationService : RegistrationService){

  }

  //   this.registerationUserForm.get('userName'); is replaced by username

  ngOnInit() {
    this.registerationUserForm = this.formBuilder.group ( {
      userName : ['nani pallapu', Validators.required], // adding simple validation
      mail : [''],
      subscribing : [false],
      password : ['', [Validators.required,Validators.maxLength(15), PasswordValidator]], // adding multiple validations in array
      confirmPassword : ['',[Validators.required, PasswordValidator]], // custom validation for confirmPassword. It will make sure length should be between 4 to 8
      address : this.formBuilder.group({
        city : [''],
        state : [''],
        postalCode : ['']
      }),
 
      // Dynamic Form Control - for this we use FormArray
      alternativeMails : this.formBuilder.array([])
    },

    // Cross Field Validation.
    { validator : PasswordMatchingValidator}

    );


    //Conditional Validation.
    this.registerationUserForm.get('subscribing')?.valueChanges
    .subscribe(checkedValue  =>{
      const email = this.registerationUserForm.get('mail');

      // if subscribing is clicked, we are setting validators for email , otherwise clearing the validators.
      if(checkedValue){
        email?.setValidators(Validators.required);
      } else{
        email?.clearValidators;
      }

      email?.updateValueAndValidity(); // finally , we are updating it to ensure correct status is reflected. 
    });

  }
/*
  registerationUserForm = this.formBuilder.group ( {
    userName : ['nani pallapu', Validators.required], // adding simple validation
    email : [''],
    password : ['', [Validators.required,Validators.maxLength(15), PasswordValidator]], // adding multiple validations in array
    confirmPassword : ['',[Validators.required, PasswordValidator]], // custom validation for confirmPassword. It will make sure length should be between 4 to 8
    address : this.formBuilder.group({
      city : [''],
      state : [''],
      postalCode : ['']
    })
  }, { validator : PasswordMatchingValidator}
  
  );

*/






/*
  // creating form module

  registerationUserForm  = new FormGroup({
    userName : new FormControl('nani pallapu'), //'nani pallapu' is default value.
    password : new FormControl(''),
    confirmPassword : new FormControl(''),

    //Nesting FormGroups
    address : new FormGroup({
      city : new FormControl(''),
      state : new FormControl(''),
      postalCode : new FormControl('')
    })

  });

*/

  // this method is used to disable the submit button and recieving registerationUserForm and print it on console.
  onSubmit(){
    this.submitted = !this.submitted;
    alert('form has been submitted!');
    console.log(this.registerationUserForm);

    this.registerationService.register(this.registerationUserForm.value).subscribe(
      response => console.log("Success!"),
      error => console.log("Error Occured")
    );
  }

  // this method is used to pre-fill registerationUserForm gettting Data from API
  // data has to maintain structure of form group if we use setValue

  loadData(){

    this.registerationUserForm.setValue({
      userName : 'Nani Babu Pallapu',
      password : 'Hyderabad@369',
      confirmPassword : 'Hyderabad@369',
      address : {
        city : 'Eluru',
        state : 'Andhra Pradesh',
        postalCode : '543001'
      }
    });
  }

 /* 
  // this method is used to pre-fill registerationUserForm gettting Data from API 
  // data don't have to maintain structure of form group if we use patchValue

  loadData(){
    this.registerationUserForm.patchValue({
      userName : 'Nani Babu Pallapu',
      password : 'Hyderabad@369',
      confirmPassword : 'Hyderabad@369',
    });
  }

*/

}
