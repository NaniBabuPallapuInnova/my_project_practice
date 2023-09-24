import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.scss']
})
export class EmployeeDetailsComponent implements OnInit{

  public employees! : any[];
  public employeeId! : number;
  constructor(private activatedRoute : ActivatedRoute, private router : Router){

  }

  ngOnInit() {

    this.employees = [{ "id": 1, "name": "Nani", "department": "JAVA", "package": "10LPA" },
    { "id": 2, "name": "Pinky", "department": "PYTHON", "package": "12LPA" },
    { "id": 3, "name": "divya", "department": "DEVOPS", "package": "14LPA" },
    { "id": 4, "name": "rajesh", "department": ".NET", "package": "18LPA"}
    ];

    /*

    //When we navigate back to the same component , Angular simply reuses the component. At that time angular does not call ngOnit() method.
    // that is why we use paramMap observables instead of snapshot.

    let id = parseInt(this.activatedRoute.snapshot.paramMap.get('id')!);
    this.employeeId = id;

    */

    this.activatedRoute.paramMap.subscribe((params: ParamMap) =>{
      let id = parseInt(params.get('id')!);
      this.employeeId = id;
    });


  }

  goPrevious(){
    let previousId = this.employeeId-1;
    this.router.navigate(['/employees',previousId]);
  }

  goNext(){
    let nextId = this.employeeId+1;
    this.router.navigate(['/employees', nextId]);
  }


  // optional route parameters, it will fetch the employeeId and navigate back to employees
  goBack(){
    let selectedId = this.employeeId ? this.employeeId : null;
    this.router.navigate(['/employees',{id:selectedId}]);
  }

  showOverview(){
    this.router.navigate(['employee-overview'],{relativeTo: this.activatedRoute});
  }

  showContact(){
    this.router.navigate(['employee-contact'],{relativeTo : this.activatedRoute});
  }

}
