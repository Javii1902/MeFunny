// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  /*
  findAllMemes: 'http://18.223.1.5:8088/meme/all',
  findAllMemesByUsername: 'http://18.223.1.5:8088/meme/userName/',
  login: "http://18.223.1.5:8088/user/login",
  submitUser: "http://18.223.1.5:8088/user/new",
  submitPost: "http://18.223.1.5:8088/meme/new",
  likeMeme: "http://18.223.1.5:8088/meme/like",
  dislikeMeme: "http://18.223.1.5:8088/meme/dislike",
  uploadFile: "http://18.223.1.5:8088/file/upload"
  //findAllMemesOfUserId: 
  */
  findAllMemes: 'http://18.223.1.5:8080/meme/all',
  findAllMemesByUsername: 'http://18.223.1.5:8080/meme/userName/',
  login: "http://18.223.1.5:8080/user/login",
  submitUser: "http://18.223.1.5:8080/user/new",
  submitPost: "http://18.223.1.5:8080/meme/new",
  likeMeme: "http://18.223.1.5:8080/meme/like",
  dislikeMeme: "http://18.223.1.5:8080/meme/dislike",
  uploadFile: "http://18.223.1.5:8080/file/upload"
  
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
