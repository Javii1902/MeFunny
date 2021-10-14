export class User{

    constructor(public userName:string, public password:string){
        this.userName = userName;
        this.password = password;
        //place string urlImageLink later;
    }

    getUserName():string{
        return this.userName;
    }
    getPassword():string{
        return this.password;
    }
}

