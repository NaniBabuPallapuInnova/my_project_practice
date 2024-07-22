import React from 'react';
import './StudentForm.css';

function StudentForm() {
    return (
        <div className="container mt-5 form-container">
            <form className="p-3 border rounded">
                <div className="mb-3 row">
                    <label htmlFor="name" className="form-label col-md-4">Student Name</label>
                    <div className="col-md-8">
                        <input type="text" className="form-control" name="name" id="name" placeholder="Enter name" />
                    </div>
                </div>
                <div className="mb-3 row">
                    <label htmlFor="behaviour" className="form-label col-md-4">Write Student Behaviour</label>
                    <div className="col-md-8">
                        <textarea className="form-control"  name="behaviour" id="behaviour" rows="3" placeholder="Enter behaviour"></textarea>
                    </div>
                </div>
                <div className="mb-3 row">
                    <label htmlFor="age" className="form-label col-md-4">Enter Age</label>
                    <div className="col-md-8">
                        <input type="number" className="form-control" name="age" id="age" placeholder="Enter age" />
                    </div>
                </div>
                <div className="mb-3 row">
                    {/* <div className="col-md-4">Is Student Active</div> */}
                    <label className="form-label col-md-4" name="isActive" htmlFor="isActive">Active Student</label>

                    <div className="col-md-8 form-check">
                        <input type="checkbox" className="form-check-input" id="isActive" />
                        {/* <label className="form-check-label" name="isActive" htmlFor="isActive">Active</label> */}
                    </div>
                </div>
                <div className="btn-group">
                    <button type="button" className="btn btn-primary">Save</button>
                    <button type="button" className="btn btn-secondary">Cancel</button>
                </div>
            </form>
        </div>
    );
}

export default StudentForm;
