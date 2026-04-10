
import { UniversalListProps } from "../types/Types"





export default function UniversalList<T>({ 
  data, selectedTime, onTimeChange, selectedItem, onItemChange,
  Selector, List, Detail 
}: UniversalListProps<T>) {

  if (selectedItem && Detail && onItemChange) {
    return <Detail item={selectedItem} onBack={() => onItemChange(null)} />;
  }

  if (selectedTime !== undefined && selectedTime !== null && List && onItemChange && onTimeChange) {
    return (
      <List
        data={data}
        time={selectedTime}
        onSelect={onItemChange}
        onBack={() => onTimeChange(null)}
      />
    );
  }

  if (Selector && onTimeChange) {
    return <Selector onSelect={onTimeChange} />;
  }

  return <div>Other things</div>;
}
