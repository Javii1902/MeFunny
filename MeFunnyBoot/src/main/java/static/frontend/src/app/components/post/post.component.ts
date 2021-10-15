import { Component, OnInit } from '@angular/core';
import { MemeService } from '../../meme.service';
import { Meme } from '../../models/Meme';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private memeService : MemeService) { }

  ngOnInit(): void {
  }
  meme = Meme;
  memeData = {};
  submitPost() {
    this.memeService.submitPost(this.memeData).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }

}
