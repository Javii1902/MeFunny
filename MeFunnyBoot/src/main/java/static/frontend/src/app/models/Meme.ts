export class Meme{

    constructor(public memeID:number , public  name:string, public description:string, public likes:number, public dislikes:number, public userName:string){
        this.memeID = memeID;
        this.name = name;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.userName = userName;
        //place string urlImageLink later;
    }

    getID():number{
        return this.memeID;
    }

    getName():string{
        return this.name;
    }

    getDescription():string{
        return this.description;
    }

    getLikes():number{
        return this.likes;
    }

    getDislikes():number{
        return this.dislikes;
    }

    getUserName():string{
        return this.userName;
    }

}