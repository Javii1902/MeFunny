import { Component, OnInit } from '@angular/core';
import { LoginService } from '../../login.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUserData = {}
  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }

  
  loginUser() {
    this.loginService.loginUser(this.loginUserData).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }
}
