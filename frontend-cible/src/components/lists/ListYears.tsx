import Card from "../commons/cards";


type Props<K> = {
	options: K[];
	onSelect: (criterion: K) => void;
	onAddClick?: () => void;
	addLabel?: string;
};



export default function ListYears<K extends string | number>({
	options,
	onSelect,
	onAddClick,
	addLabel = "Add New"
}: Props<K>) {
	return (
		<div>
			{options.map((option) => (
				<Card
					key={option.toString()}
					title={option.toString()}
				/>
			))}
		</div>
	);
}