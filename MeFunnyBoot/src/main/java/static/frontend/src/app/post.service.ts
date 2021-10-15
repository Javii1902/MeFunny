import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Meme } from './models/Meme';
import { environment } from '../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient:HttpClient) { }


  submitPost(Meme: {}){
    //let user = User.find((user: any) => user.id === query);
    //return this.http.post<any>(this.loginUrl, User);
    return this.httpClient.post<any>(environment.login, Meme) as Observable<Meme[]>;
  }
}