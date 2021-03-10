


export const UserList = (props) => {
    let users= props.usersList();
    let userItem=users.map(user=>( 
        <div>
            Id: {user.id}
            Contraseña: {user.contraseña}
            Email: {user.email}
        </div>
    ))
    
    return(
        <div>
            {userItem}
        </div>
    )
}