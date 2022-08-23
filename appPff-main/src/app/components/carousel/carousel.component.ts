import { Component, OnInit } from '@angular/core';
import { ThemeSerrviceService } from 'src/app/services/theme-serrvice.service';

@Component({
  selector: 'app-carousel',
  templateUrl: './carousel.component.html',
  styleUrls: ['./carousel.component.css']
})
export class CarouselComponent implements OnInit {
 imageList=[]
  constructor(private ThemSer:ThemeSerrviceService) { }

  ngOnInit(): void {

    // this.ThemSer.listTemes.forEach(t => {
    //   this.imageList.push(t.image)
    // });
    // console.log(this.imageList);
    
  }

}
