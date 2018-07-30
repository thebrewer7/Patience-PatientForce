import { Component, OnInit } from '@angular/core';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-rater',
  templateUrl: './rater.component.html',
  styleUrls: ['./rater.component.css']
})
export class RaterComponent implements OnInit {
  constructor() { }

  rating() {
    $('.rating input').change(function () {
      var $radio = $(this);
      console.log($radio.val());
      $('.rating .selected').removeClass('selected');
      $radio.closest('label').addClass('selected');
    });
  }

  ngOnInit() {
  }

}
