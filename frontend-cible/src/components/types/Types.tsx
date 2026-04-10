import { ComponentType } from "react";

export type TaskDTO = {
    id: number;
    title: string;
    dueDate: string | null;
    completedAt: string | null;
  };

export type TaskGroupDTO = {
    id: number;
    name: string;
    tasks: TaskDTO[];
  };
  
  
export type TaskGroupListProps = {
    data: TaskGroupDTO[];
    year: string;
    onSelect: (group: TaskGroupDTO) => void;
    onBack: () => void;
  };
  





export type TaskDetailProps = {
    group: TaskGroupDTO;
    onBack: () => void;
  };
  







  export type UniversalListProps<T> = { 
    data: T[];
    
    selectedTime?: string | null;
    onTimeChange?: (time: string | null) => void;
    selectedItem?: T | null;
    onItemChange?: (item: T | null) => void;

    Selector?: ComponentType<{ 
      onSelect: (time: string) => void 
    }>;
    
    List?: ComponentType<{ 
      data: T[]; 
      time: string; 
      onSelect: (item: T) => void; 
      onBack: () => void 
    }>;

    Detail?: ComponentType<{ 
      item: T; 
      onBack: () => void 
    }>;
};
