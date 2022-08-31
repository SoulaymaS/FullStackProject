export class Session {
  
    constructor(
      public id: string,
      public date: Date,
      public duration:number,
      public enroledUsers:[],
      public formation:string   
    ) {

  }
}