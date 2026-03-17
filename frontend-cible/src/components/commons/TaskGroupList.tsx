import js_icon from "../../assets/js-icon.png";
import Button from "./button";



type Props = {
    data: TaskGroupDTO[];
    year: string;
    onSelect: (group: TaskGroupDTO) => void;
    onBack: () => void;
  };
  
  export default function TaskGroupList({ data, year, onSelect, onBack }: Props) {
    return (
      <div className="p-4">

      <div className="flex justify-between items-center">
        <h1 className="text-4xl font-bold mb-2 text-white">
          Tasks
        </h1>

        <Button text="NEW TASK" iconName="arrow-left" /> {/*I think we have to do a better reusable button with the size of button and clickable function */}
      </div>

      <h2 className="text-2xl font-bold mb-3 text-white">
        {year}
      </h2>






  
        {data.map((tg) => (
          <div
            key={tg.id}
            onClick={() => onSelect(tg)}
            className="bg-gray-100 rounded-md cursor-pointer mb-3 transition hover:bg-[#10B981] hover:text-white font-semibold max-w-md flex overflow-hidden group"
          >
            <img src={js_icon} alt="" className="w-1/5 object-cover" />
            <div className="p-4 flex-1">
              {tg.name}
              <div className="flex h-3.5 w-full overflow-hidden rounded-full bg-gray-200 mt-4">
                <div className="w-1/2 h-full bg-[#10B981] group-hover:bg-[#065F46] rounded-full transition-colors"></div>
              </div>
            </div>
          </div>
        ))}
  
        <button onClick={onBack} className="mt-4 px-4 py-2 bg-[#10B981] text-white rounded-lg">
          Back
        </button>
      </div>
    );
  }