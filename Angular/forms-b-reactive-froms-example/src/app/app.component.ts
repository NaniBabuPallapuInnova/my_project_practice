import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms'
import { FormControl, } from '@angular/forms'
import { PasswordValidator } from './password-validator';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Reactive Form Example';
  submitted : boolean = false;



//   this.registerationUserForm.get('userName'); is replaced by username

get userName(){
  return this.registerationUserForm.get('userName');
}

get password(){
  return this.registerationUserForm.get('password');
}

get confirmPass(){
  return this.registerationUserForm.get('confirmPassword');
}





  constructor(private formBuilder : FormBuilder){

  }

  //   this.registerationUserForm.get('userName'); is replaced by username

  ngOnInit() {
  

  }

  registerationUserForm = this.formBuilder.group({
    userName : ['nani pallapu', Validators.required], // adding simple validation
    password : ['', [Validators.required,Validators.maxLength(8)]], // adding multiple validations in array
    confirmPassword : ['',[Validators.required, PasswordValidator]], // custom validation for confirmPassword. It will make sure length should be between 4 to 8
    address : this.formBuilder.group({
      city : [''],
      state : [''],
      postalCode : ['']
    })
  });






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
  onSubmitt(registerationUserForm : FormGroup){
    this.submitted = !this.submitted;
    alert('form has been submitted!');
    console.log(registerationUserForm);
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
