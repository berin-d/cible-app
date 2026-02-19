
export interface UserRegisterDto {
    username: string;
    email: string;
    password: string;
}

export interface UserLoginDto {
    email: string;
    password: string;
}

export interface User {
    id: string;
    username: string;
    email: string;
    createdAt: string;
}