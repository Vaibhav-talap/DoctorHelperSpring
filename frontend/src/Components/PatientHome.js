import { render } from "@testing-library/react";
import { Link } from 'react-router-dom';
import { useNavigate } from "react-router-dom";
import phomeclasses from './PatientHome.module.css';
import React, { useState } from "react";
import ErrorModal from "./ErrorModal";


const PatientHome = () => {
    const navigate = useNavigate();
    const [searchedEmail, setSearchedEmail] = useState('');
    const [error, setError] = useState();
    const errorHandler = () => {
        setError(null);
    }


    const setvalidateedData = (data) => {
        // { data === 'ok' ? navigate('/doctorHome') : setError(data) }
        // console.log(data.access);
        // localStorage.setItem('token', data.access);
        { data.responseMessage === 'ok' && navigate(`/PatientMedicalRecordList/${data.id}`) }
        { data.responseMessage != 'ok' && setError(data.responseMessage) }
        // console.log(data)

    }

    const searchedEmailHandler = (event) => {
        setSearchedEmail(event.target.value);
    }
    const doctorHomeSubmitHandler = (event) => {
        event.preventDefault();
        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email: searchedEmail })
        };
        fetch('http://127.0.0.1:8080/clinic/patientId', requestOptions,{ mode: 'no-cors'})
            .then(response => response.json())
            .then(data => setvalidateedData(data));

    }

    return (
        <div>
            {error && <ErrorModal data={error} onClick={errorHandler} />}
            <div className={`${phomeclasses['header']} ${phomeclasses['flex']}`}>

                <div className={phomeclasses['doctorHome-body']}>

                    <div className={phomeclasses['inner-box']}>
                        <main className={phomeclasses['search-body']}>
                            <form onSubmit={doctorHomeSubmitHandler}>
                                <div>
                                    <label htmlFor="email">Patient Email</label>
                                    <input type="email" name="email" onChange={searchedEmailHandler} required />
                                </div>
                                <div>
                                    <button type="submit">Search</button>
                                </div>

                            </form>
                        </main>
                    </div>
                </div>
            </div>
        </div>

    );
}
export default PatientHome;