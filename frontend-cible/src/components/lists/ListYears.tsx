import { useNavigate } from "react-router-dom";
import Card from "../commons/cards";


interface Props {
	datas: string[];
};


export default function ListYears({
	datas
}: Props) {
	const navigate = useNavigate();
	return (
		<div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
			{datas.map((option) => (
				<Card
					key={option}
					title={option}
					addCard={false}
					navigateTo={() => navigate(`/dashboard/taskGroup/${option}`)}
				/>
			))}

			<Card
				addCard={true}
			/>
		</div>
	);
}