import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './models/User';
import { environment } from '../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
private loginUrl = "http://localhost:8080/loginv2";

  constructor(private httpClient:HttpClient) { }


  loginUser(User: {}){
    //let user = User.find((user: any) => user.id === query);
    //return this.http.post<any>(this.loginUrl, User);
    return this.httpClient.post<any>(environment.login, User) as Observable<User[]>;
  }

  findAllMemesById(){

  }
}
