export const isTauri = (): boolean => {
  return typeof window !== 'undefined' && '__TAURI__' in window;
};

/*
export const isAuthenticated = (): boolean => {
  return !!localStorage.getItem('authToken');
};
*/