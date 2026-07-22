export default function Main({ children }: { children: React.ReactNode }) {
  return (
    <div className="bg-[#1A1A1E] w-full min-h-screen">
      <div className="p-2">
        {children}
      </div>
    </div>
  );
}