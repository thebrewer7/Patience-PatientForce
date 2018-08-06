import { Component, OnInit } from '@angular/core';
import { ConnectorService } from '../../services/connector/connector.service';
import { tap } from 'rxjs/operators';
import { Details } from '../../objects/details';
import { UserDataService } from '../../services/userData/user-data.service';
declare var jquery: any;
declare var $: any;

@Component({
  selector: 'app-rater',
  templateUrl: './rater.component.html',
  styleUrls: ['./rater.component.css']
})
export class RaterComponent implements OnInit{
  public data: Details;
  public rateVal: number;

  constructor(private conn: ConnectorService, private userData: UserDataService) { }

  ngOnInit() {
    this.userData.currentData.subscribe(data => this.data = data);
  }

  rating() {
    $('.rating input').change(function () {
      this.rateVal = $(this).val();
      const $radio = $(this);

      $('.rating .selected').removeClass('selected');
      $radio.closest('label').addClass('selected');
    });
  }

  submitReview(review, rate1) {
    this.conn.submitReviewByName(rate1.control.value, review.control.value, this.data.role, Date.now().toLocaleString(), this.data.id).pipe(
      tap(
        data => {
          console.log(data);
        }
      )
    ).subscribe();
  }

}
