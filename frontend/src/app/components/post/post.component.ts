import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MemeService } from '../../meme.service';
import { Meme } from '../../models/Meme';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
//upload file
  selectedFile: File = null;
  
let 
  constructor(private memeService : MemeService, httpClient: HttpClient) { }

  ngOnInit(): void {
  }
  onFileSelected(event) {
    console.log(event)
    this.selectedFile = <File>event.target.files[0];
  }

  onUpload(){
    this.memeService.uploadFile(this.selectedFile).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )

    this.memeService
  }

  meme = new Meme(100, "newName", "newDescription", 0, 0, String(localStorage.getItem('currentUser')));
  memeData = {};
  submitPost() {
    this.memeService.submitPost(this.meme).subscribe(
      (data) => console.log(data),
      
      (error) => {
        console.log("Error handler was invoked")
      }
    )
  }


}


