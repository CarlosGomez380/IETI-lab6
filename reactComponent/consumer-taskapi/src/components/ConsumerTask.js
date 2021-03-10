
import React, { useState} from 'react';
import { UserList} from './UserList';


export const ConsumerTask = (props) => {
    
    const [users, setUsers] = useState([]);

    const componentDidMount= () => {
        fetch('http://taskplanner.southcentralus.azurecontainer.io:8080/home')
            .then(response => response.json())
            .then(data => {
                setUsers(data);
            });
            
        return users;
    }


    return (
        <div>
            
            <UserList usersList={componentDidMount}/>
        </div>
    );

}