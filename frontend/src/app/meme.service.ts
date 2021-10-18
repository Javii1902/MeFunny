import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Meme } from '../app/models/Meme';
import { environment } from '../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class MemeService {

  constructor(private httpClient:HttpClient) {}

  // We have to define what this service provides now.

  findAllMemes():Observable<Meme[]>{
    /*
      Please note that the HttpClient methods return observables of the response bodies. What is an observable? An observable, like a promise, is a representation of a value that we don't have yet but expect to have at some point.

      An observable is not exactly like a promise. For one, the callback function defined for resolving an observable is lazy whereas the callback defined for resolving a promise eager. Observables can be reused whereas promises cannot once they have been resolved; in other words, observables can emit multiple values over time.

      NOTE: You can immediately cast your JSON (just deserialize it) into an array of cards. This means that the observable will emit an array of cards.
    */
    return this.httpClient.get(environment.findAllMemes) as Observable<Meme[]>;
  }

  findAllMemesByUsername():Observable<Meme[]>{

    return this.httpClient.get(environment.findAllMemesByUsername + localStorage.getItem('currentUser')) as Observable<Meme[]>;
  }

  likeMeme(id: number):Observable<Meme[]>{
    
    console.log("Service id: " + id)
    return this.httpClient.post<any>(environment.likeMeme + "?id=" + id, null) as unknown as Observable<Meme[]>;
  }

  dislikeMeme(id: number):Observable<Meme[]>{
    
    console.log("Service id: " + id)
    return this.httpClient.post<any>(environment.dislikeMeme + "?id=" + id, null) as unknown as Observable<Meme[]>;
  }

  submitPost(Meme: {}){
    //let user = User.find((user: any) => user.id === query);
    //return this.http.post<any>(this.loginUrl, User);
    return this.httpClient.post<any>(environment.submitPost, Meme) as Observable<Meme[]>;
  }

  uploadFile(selectedFile: File) {
    return this.httpClient.post<any>(environment.uploadFile, File) as Observable<Meme[]>;
  }

}
