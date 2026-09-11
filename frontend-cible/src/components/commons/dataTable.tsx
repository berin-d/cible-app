import type { ReactNode } from "react";

export type DataTableColumn<T> = {
    key: keyof T;
    header: ReactNode;
    render?: (value: T[keyof T], row: T) => ReactNode;
    className?: string;
};

export type DataTableProps<T extends { id?: string | number | null }> = {
    columns: DataTableColumn<T>[];
    data: T[];
    emptyMessage?: ReactNode;
    onRowClick?: (row: T) => void;
    rowClassName?: string;
};

export default function DataTable<T extends { id?: string | number | null }>({
    columns,
    data,
    emptyMessage = "Aucune donnée à afficher.",
    onRowClick,
    rowClassName = "",
}: DataTableProps<T>) {
    return (
        <div className="w-full overflow-x-auto rounded-lg border border-slate-700 bg-zinc-900">
            <table className="w-full min-w-[32rem] border-collapse text-left text-sm text-slate-200">
                <thead className="border-b border-slate-700 bg-zinc-800 text-xs uppercase tracking-wide text-slate-400">
                    <tr>
                        {columns.map((column, columnIndex) => (
                            <th key={`${String(column.key)}-${columnIndex}`} scope="col" className={`px-4 py-3 font-medium ${column.className ?? ""}`}>
                                {column.header}
                            </th>
                        ))}
                    </tr>
                </thead>
                <tbody className="divide-y divide-slate-800">
                    {data.length === 0 ? (
                        <tr>
                            <td colSpan={columns.length} className="px-4 py-8 text-center text-slate-500">
                                {emptyMessage}
                            </td>
                        </tr>
                    ) : (
                        data.map((row, index) => (
                            <tr
                                key={row.id ?? index}
                                onClick={() => onRowClick?.(row)}
                                className={`transition-colors hover:bg-zinc-800}`}
                            >
                                {columns.map((column, columnIndex) => (
                                    <td key={`${String(column.key)}-${columnIndex}`} className={`px-4 py-3 ${column.className ?? ""}`}>
                                        {column.render ? column.render(row[column.key], row) : String(row[column.key] ?? "-")}
                                    </td>
                                ))}
                            </tr>
                        ))
                    )}
                </tbody>
            </table>
        </div>
    );
}