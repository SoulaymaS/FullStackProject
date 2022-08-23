export class User {
  
    constructor(
      public _id: number,
      public nom:string,
      public prenom:string,
      public email:string,
      public password:string,
      public role:string
    ) {

  }
}