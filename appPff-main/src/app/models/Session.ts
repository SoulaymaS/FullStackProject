export class Session {
  
    constructor(
      public _id: number,
      public date: Date,
      public duration:number,
      public enroledUsers:[],
      public formation:string   
    ) {

  }
}