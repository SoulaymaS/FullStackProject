import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.css']
})
export class AddStaffComponent implements OnInit {
  regArry:any={}
  passwordPtn ='^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,16}$'
  constructor() { }

  ngOnInit(): void {
  }
  addStaff(newS){
    console.log(newS);
    

  }

}
