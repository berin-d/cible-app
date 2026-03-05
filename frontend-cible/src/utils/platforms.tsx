export const isTauri = (): boolean => {
  return typeof window !== 'undefined' && '__TAURI__' in window;
};

