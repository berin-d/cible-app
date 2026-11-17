export function getAuthToken(): string | null {
    return sessionStorage.getItem('token') || localStorage.getItem('token');
}

export function getRememberedAuthToken(): string | null {
    return localStorage.getItem('token');
}

export function storeAuthToken(token: string, rememberMe: boolean): void {
    localStorage.removeItem('token');
    sessionStorage.removeItem('token');

    if (rememberMe) {
        localStorage.setItem('token', token);
    } else {
        sessionStorage.setItem('token', token);
    }
}

export function clearAuthToken(): void {
    localStorage.removeItem('token');
    sessionStorage.removeItem('token');
}
