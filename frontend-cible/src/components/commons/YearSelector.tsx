type Props = {
    onSelect: (year: string) => void;
  };
  
  export default function YearSelector({ onSelect }: Props) {
    const years = [...new Set(["2025", "2028", "2027", new Date().getFullYear().toString()])]
      .sort((a, b) => Number(a) - Number(b));
  
    return (
      <div className="flex flex-row gap-2 p-4">
        {years.map((y) => (
          <div
            key={y}
            onClick={() => onSelect(y)}
            className="rounded-xl border border-gray-200 bg-white px-4 py-3 text-sm font-medium text-gray-700 shadow-sm transition hover:bg-[#10B981] hover:text-white hover:border-[#10B981] cursor-pointer"
          >
            {y}
          </div>
        ))}
      </div>
    );
  }