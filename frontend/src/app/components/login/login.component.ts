import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { LoginService } from '../../login.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  

  constructor(private loginService: LoginService,
              private router: Router) { }
  
  ngOnInit(): void {
    console.log(localStorage.getItem('currentUser'));

    if(localStorage.getItem('currentUser') == "nullUser")
    {
        //login
        console.log("null user is logged in")
    }
    else
    {
        //accounthome
        console.log(localStorage.getItem('currentUser')+ " is logged in")

    }
  }
  
  user = new User("nullUser", "nullPassword");

  currentUser = this.user;
  submitted = false;

  onSubmit()
  {
    this.submitted = true;
    
  }


  loginUserData = {}
  loginUser() {
    
    this.loginService.loginUser(this.user).subscribe(
      (user) => console.log(user.toString),
      //set current user
      
      //make account component, similar to home
      //instead of get all, get all byID
      //redirect to account

      (error) => {
        console.log("Error handler was invoked")
      }
      
    )

    localStorage.setItem('currentUser', this.user.userName)
    console.log(localStorage.getItem('currentUser'));
    this.router.navigateByUrl('/account')
    //redirect to account page
  }

  submitUser() {
    this.loginService.submitUser(this.user).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }
}
