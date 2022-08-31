import { Formateur } from "./Formateur";
import { Session } from "./Session";
import { Theme } from "./theme";

export class Formation {
  
    constructor(
      public id: string,
      public title: string,
      public description: string,
      public duration:string,
      public formateur: Formateur,
      public sessions:[Session],
      public theme:Theme
     
    ) {

  }
}