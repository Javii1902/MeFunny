import { Component, Input, EventEmitter, OnInit, Output } from '@angular/core';
import { Meme } from '../../models/Meme';
import { MemeService } from 'src/app/meme.service';

@Component({
  selector: 'app-meme',
  templateUrl: './meme.component.html',
  styleUrls: ['./meme.component.css']
})
export class MemeComponent implements OnInit {

  constructor(private memeService:MemeService) { }
    
  ngOnInit(): void {
  }

  tmeme = new Meme(1, 'emitname', 'emitdesc', 1, 1, 'emituNam');

  @Input()
  meme:Meme;

  @Output()
  updateMemeEvent = new EventEmitter<Meme>();

  updatedMeme:Meme = new Meme(1, 'emitname', 'emitdesc', 1, 1, 'emituNam');

  updateMemeState(){
    this.updateMemeEvent.emit(this.updatedMeme);
  }

  likeMeme(){
    console.log("i like");
    console.log(this.meme.id)
    this.memeService.likeMeme(this.meme.id).subscribe(
      (data) => console.log(this.meme.id),

      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }

  dislikeMeme(){
    console.log("i dislike");
    console.log(this.meme.id)
    this.memeService.dislikeMeme(this.meme.id).subscribe(
      (data) => console.log(this.meme.id),

      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }
  


}
