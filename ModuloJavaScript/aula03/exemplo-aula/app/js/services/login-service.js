import { setTimeout } from "timers";

const registeredUsers = [
    {
        email: 'thanos@gmail.com',
        password: '123123'
    },
    {
        email: 'thor@bol.com.br',
        password: '123123'
    }
]

class LoginService{
    static authenticate(email,password, onSuccess, onError){
        const matchingUser = registeredUsers.find(user=>{
            return user.email === email && user.password===password
        })
        setTimeout(()=>{
        if(!matchingUser){
            onError(new InvalidCredentialsError('Invalid e-mail or password.'))
        }else{
            onSuccess(matchingUser)
        }},2000)
    }

    static  hasLoggedUser(){

    }
}

class InvalidCredentialsError extends Error{

}

export default LoginService