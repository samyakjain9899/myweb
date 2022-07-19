export class BookRideComponentComponent implements OnInit {
  sp=false;
  sr=false;
  ep=false;
  ridedetail1=false;
  filtercondition:string="";
  ridedetail!:any;
  ShowRide=false;
  BookDisable=false;
  x!:number;
  i=0;
  InShowRide(){
    this.i=this.i+1;
    if(this.i%2!=0){
      this.ShowRide=true;
      this.sr=true;
      this.filtercondition="";
    }
    else{
      this.ShowRide=false;
      this.ridedetail1=false;
      this.BookDisable=false;
      // this.ep=false;
      // this.sp=false;
    }
  }
  FilterToOffice(){
    this.sr=true;
    this.ep=true;
    this.sp=false;
    this.filtercondition="tooffice";
  }
  FilterFromOffice(){
    this.sr=true;
    this.ep=false;
    this.sp=true;
    this.filtercondition="fromoffice";
  }


  constructor() { }

  ngOnInit(): void {
  }
  RideDetails:any[]=[
    {StartPoint:"Infosys",EndPoint:"RailwayStation",Seats:5,id:1,offerid:"one",name:"pratik",car:"sedan",totalseats:7},
    {StartPoint:"Sahid Park",EndPoint:"Infosys",Seats:4,id:2,offerid:"two",name:"muskan",car:"XUV",totalseats:7},
    {StartPoint:"Infosys",EndPoint:"Mahakaleshwar",Seats:6,id:1,offerid:"three",name:"Deepak",car:"sedan",totalseats:7},
    {StartPoint:"Nanakheda",EndPoint:"Infosys",Seats:5,id:1,offerid:"four",name:"vedant",car:"Lambo",totalseats:7}
  ];
  rideDetails(details:any){
  this.x=this.RideDetails.indexOf(details);
  this.ridedetail=details;
  this.ridedetail1=true;
 
  } 
  booking(details:any){
    if(details.Seats>0){
      this.RideDetails[this.x].Seats-=1;
      // details.Seats-=1;
      alert("booking Success");
      this.BookDisable=true;
  
    }
    else{
      alert("No seats");
    }
  }
  cancel(details:any){
    if(details.Seats<=details.totalseats){
      this.RideDetails[this.x].Seats+=1;
      // details.Seats-=1;
      alert("ride canceled");
      this.BookDisable=false;
  
    }
    else{
      alert("No more seats to add");
    }
  }
}
