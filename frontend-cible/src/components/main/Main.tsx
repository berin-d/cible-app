type TaskDTO = {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  userId: number;
  username: string;
  statusId: number | null;
  statusName: string | null;
  priorityId: number | null;
  priorityName: string | null;
  taskGroupId: number;
  taskGroupName: string;
  createdAt: string;
  updatedAt: string;
  completedAt: string | null;
  taskOrder: number;
};




export default function Main({ children }: { children: React.ReactNode }) {
  return (
    <div className="bg-[#1A1A1E] w-full min-h-screen">
      <div className="p-2">
        {children}
      </div>
    </div>
  );
}