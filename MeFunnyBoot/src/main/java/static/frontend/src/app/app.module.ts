;
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CustomPipePipe } from './custom-pipe.pipe';



import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav/nav.component';
import { LoginComponent } from './login/login.component';
import { MemeComponent } from './meme/meme.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    LoginComponent,
    MemeComponent,
    HomeComponent,
    CustomPipePipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
