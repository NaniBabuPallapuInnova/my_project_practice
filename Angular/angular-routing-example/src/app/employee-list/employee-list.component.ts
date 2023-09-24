import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router , ParamMap} from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {

  public employees!: any[];

  public selectedId! : number ;

  constructor(private router : Router, private activatedRoute : ActivatedRoute) {

  }
  ngOnInit() {
    this.employees = [{ "id": 1, "name": "Nani", "department": "JAVA", "package": "10LPA" },
    { "id": 2, "name": "Pinky", "department": "PYTHON", "package": "12LPA" },
    { "id": 3, "name": "divya", "department": "DEVOPS", "package": "14LPA" },
    { "id": 4, "name": "rajesh", "department": ".NET", "package": "18LPA"}
    ];

    // optional route parameters
    this.activatedRoute.paramMap.subscribe((params : ParamMap)=>{
      let id = parseInt(params.get('id')!);
      this.selectedId = id;

    });
  }

  onSelect(employee : any){
    this.router.navigate(['/employees',employee.id])   // passing the parameter id
  }

  // optional route parameters
  isSelected(employee : any){
    return employee.id == this.selectedId;
  }

}
