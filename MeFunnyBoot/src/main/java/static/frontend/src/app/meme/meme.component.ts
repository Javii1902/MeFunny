import { Component, Input, EventEmitter, OnInit, Output } from '@angular/core';
import { Meme } from '../models/Meme';

@Component({
  selector: 'app-meme',
  templateUrl: './meme.component.html',
  styleUrls: ['./meme.component.css']
})
export class MemeComponent implements OnInit {

  constructor() { }
    
  ngOnInit(): void {
  }

  @Input()
  meme!: Meme

  @Output()
  updateMemeEvent = new EventEmitter<Meme>();

  updatedMeme:Meme = new Meme(1, 'emitname', 'emitdesc', 1, 1, 'emituNam');

  updateMemeState(){
    this.updateMemeEvent.emit(this.updatedMeme);
  }
  


}
