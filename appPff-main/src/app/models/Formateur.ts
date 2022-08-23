import { Formation } from "./formation";
import { Session } from "./Session";

export class Formateur {
  
    constructor(
      public nom: string,
      public prenom: string,
      public cin:number,
      public profession: string,
      public formations:[Formation],
      public sessions:[Session]   
       ) {

  }
}