import { Component, OnInit } from '@angular/core';
import { Meme } from '../../models/Meme';
import { MemeService } from '../../meme.service';

import { MemeComponent } from '../meme/meme.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private memeService:MemeService) { }

  ngOnInit(): void {
    //if in current user in session
    //this.findAllMemesById();
    //else login null
    this.findAllMemes()

  }

  memes!:Meme[];

  meme:Meme = new Meme(1, 'Enter Name', 'Enter Description', 0,0, 'enter username')
  // In order to use property binding, we bind an element attribute's value to our component state:

  isVisible:boolean = true;
  buttonText:string = 'Hide Dynamic Card';
  hideMeme(){
    this.isVisible = !this.isVisible;
    if(this.isVisible){
      this.buttonText = 'Show Dynamic Card';
    } else this.buttonText = 'Hide Dynamic Card';
  }

  submitMeme(){
    let new_meme = new Meme(this.meme.id, this.meme.name, this.meme.description, this.meme.likes, this.meme.dislikes, this.meme.userName);
    this.memes.push(new_meme);
  }

  

  // This receives the emitted value from the child (as specified in the view)
  receiveMemeFromChild(receivedMeme:Meme){
    console.log(receivedMeme);
  }

  findAllMemes(){
    // You have to subscribe to an observable to access the value that is emitted.
    this.memeService.findAllMemes().subscribe(
      // The callback that is invoked if the http request is successful
      (data) => {
        this.memes = data
        console.log(this.memes)
      },
      // The callback that is invoked is something goes wrong.
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }

  


}
