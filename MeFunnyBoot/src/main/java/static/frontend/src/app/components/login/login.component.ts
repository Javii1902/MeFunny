import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { LoginService } from '../../login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) { }
  
  ngOnInit(): void {
  }
  
  user = User;
  loginUserData = {}
  loginUser() {
    this.loginService.loginUser(this.loginUserData).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }

  submitUser() {
    this.loginService.submitUser(this.loginUserData).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }
}
